package com.countrycinema.ua.dto.mail;

import com.countrycinema.ua.exception.InternalException;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.core.io.InputStreamSource;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
@ToString(exclude = "attachment")
@EqualsAndHashCode(exclude = "attachment")
public class MailDTO {

    private String subject;
    private String message;

    private List<String> recipients;

    private String attachmentName;
    private InputStreamSource attachment;

    private boolean isHtml;

    public String getFirstRecipient() {
        if (CollectionUtils.isEmpty(recipients)) {
            throw new InternalException("Could not get any recipient");
        }
        return recipients.get(0);
    }

    public MailDTO(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public static MailDTO asHtml(String subject, String message, String recipient) {
        return new MailDTO(subject, message)
                .setRecipients(Lists.newArrayList(recipient))
                .setHtml(true);
    }

    public static MailDTO asRawText(String subject, String message, String recipient) {
        return new MailDTO(subject, message)
                .setRecipients(Lists.newArrayList(recipient))
                .setHtml(true);
    }

    public static MailDTO as(String subject, String message, String recipient, boolean isHtml,
                                    String attachmentName, InputStreamSource attachment) {
        return new MailDTO(subject, message)
                .setRecipients(Lists.newArrayList(recipient))
                .setHtml(isHtml)
                .setAttachmentName(attachmentName)
                .setAttachment(attachment);
    }

    public static MailDTO as(String subject, String message, List<String> recipients, boolean isHtml,
                                    String attachmentName, InputStreamSource attachment) {
        return new MailDTO(subject, message)
                .setRecipients(recipients)
                .setHtml(isHtml)
                .setAttachmentName(attachmentName)
                .setAttachment(attachment);
    }




}

