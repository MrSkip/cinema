package com.countrycinema.ua.component;

import com.countrycinema.ua.common.Logger;
import com.countrycinema.ua.config.properties.mail.MailProperties;
import com.countrycinema.ua.dto.mail.MailDTO;
import com.countrycinema.ua.exception.InternalException;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.CompletableFuture;

@Component
@EnableConfigurationProperties(MailProperties.class)
public class MailComponent {

    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;

    @Autowired
    @SuppressWarnings("all")
    public MailComponent(JavaMailSender mailSender, MailProperties mailProperties) {
        this.mailSender = mailSender;
        this.mailProperties = mailProperties;
    }

    public void asyncSendMail(MailDTO mailDTO) {
        CompletableFuture.runAsync(() -> sendMail(mailDTO));
    }

    public void sendMail(MailDTO mailDTO) {
        try {
            final MimeMessage message = mailSender.createMimeMessage();
//            message.setHeader(mailProperties.getHeaderParam(), mailProperties.getEncodingOptions());

            boolean multipart = !Strings.isNullOrEmpty(mailDTO.getAttachmentName());
            final MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

            if (CollectionUtils.isEmpty(mailDTO.getRecipients())) {
                String error = "The recipient was not specified";
                Logger.error(error);
                throw new InternalException(error);
            }

            helper.setTo(mailDTO.getRecipients().toArray(new String[0]));
            helper.setSubject(mailDTO.getSubject());
            helper.setText(mailDTO.getMessage(), mailDTO.isHtml());
            helper.setFrom(new InternetAddress(mailProperties.getAccountFrom()));

            if (multipart) {
                helper.addAttachment(mailDTO.getAttachmentName(), mailDTO.getAttachment());
            }

            mailSender.send(message);

            Logger.debug("Here is email object which was sent: {}", mailDTO);
        } catch (final Exception e) {
            String message = "Error while sending mail. Check input data";
            Logger.error(message, e);
            throw new InternalException(message, e);
        }
    }

}
