package com.countrycinema.ua.utils;

import com.countrycinema.ua.common.Logger;
import com.countrycinema.ua.exception.BadInputParamException;
import com.countrycinema.ua.exception.ObjectNotFoundException;
import com.countrycinema.ua.persistence.entity.core.id.IdComponent;
import com.google.common.base.Strings;
import org.springframework.http.HttpStatus;

public class Validator {

    private Validator() {
        throw new IllegalStateException("Utility class");
    }

    public static Action validate(String... args) {
        boolean isValid = true;
        if (args == null) {
            isValid = false;
        } else {
            for (String arg : args) {
                if (Strings.isNullOrEmpty(arg)) {
                    isValid = false;
                    break;
                }
            }
        }

        return new Action(isValid, HttpStatus.BAD_REQUEST);
    }

    public static Action validate(Object... args) {
        boolean isValid = true;
        if (args == null) {
            isValid = false;
        } else {
            for (Object arg : args) {
                if (arg == null) {
                    isValid = false;
                    break;
                }
            }
        }

        return new Action(isValid, HttpStatus.BAD_REQUEST);
    }

    public static Action checkIds(Long... ids) {
        boolean isValid = true;
        if (ids == null) {
            isValid = false;
        } else {
            for (Long arg : ids) {
                if (arg == null || arg <= 0) {
                    isValid = false;
                    break;
                }
            }
        }

        return new Action(isValid, HttpStatus.BAD_REQUEST);
    }

    public static Action validate(IdComponent... ids) {
        boolean isValid = true;
        if (ids == null) {
            isValid = false;
        } else {
            for (IdComponent arg : ids) {
                if (arg == null) {
                    isValid = false;
                    break;
                }
            }
        }

        return new Action(isValid, HttpStatus.NOT_FOUND);
    }

    public static Action checkPositiveNumbers(Number... args) {
        boolean isValid = true;
        if (args == null) {
            isValid = false;
        } else {
            for (Number arg : args) {
                if (arg == null || arg.intValue() < 0) {
                    isValid = false;
                    break;
                }
            }
        }

        return new Action(isValid, HttpStatus.BAD_REQUEST);
    }

    public static class Action {

        private boolean isValid;
        private HttpStatus httpStatus;

        public Action(boolean result, HttpStatus status) {
            this.isValid = result;
            this.httpStatus = status;
        }

        public final void withException() {
            if (!isValid) {
                Logger.error(httpStatus.getReasonPhrase());
                createException(httpStatus.getReasonPhrase());
            }
        }

        public final void withException(String message) {
            if (!isValid) {
                Logger.error(message);
                createException(message);
            }
        }

        public final boolean isValid() {
            return isValid;
        }

        public Action withCheck(String... args) {
            if (isValid) {
                isValid = Validator.validate(args).isValid();
            }
            return this;
        }

        public Action withCheck(Object... args) {
            if (isValid) {
                isValid = Validator.validate(args).isValid();
            }
            return this;
        }

        public Action withCheck(IdComponent... args) {
            if (isValid) {
                isValid = Validator.validate(args).isValid();
            }
            return this;
        }

        private void createException(String message) {
            if (httpStatus.equals(HttpStatus.BAD_REQUEST)) {
                if (Strings.isNullOrEmpty(message)) {
                    throw new BadInputParamException();
                } else {
                    throw new BadInputParamException(message);
                }
            } else if (httpStatus.equals(HttpStatus.NOT_FOUND)) {
                if (Strings.isNullOrEmpty(message)) {
                    throw new ObjectNotFoundException();
                } else {
                    throw new ObjectNotFoundException(message);
                }
            }
        }

    }

}
