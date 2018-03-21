package org.hyl.commons.result.enums;

import org.apache.commons.lang3.StringUtils;

public enum Result {
    SUCCESS(200, "请求成功"),
    SUCCESS_POST(200, "新增数据成功"),
    SUCCESS_DELETE(200, "删除数据成功"),
    SUCCESS_GET(200, "查询数据成功"),
    SUCCESS_PUT(200, "修改数据成功"),
    ERROR(500, "请求失败，请稍后再试"),
    ERROR_POST(500, "新增数据失败，请稍后再试"),
    ERROR_DELETE(500, "删除数据失败，请稍后再试"),
    ERROR_GET(500, "查询数据失败，请稍后再试"),
    ERROR_PUT(500, "修改数据失败，请稍后再试");

    private final int state;

    private final String message;

    Result(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public enum Network {
        SUCCESS(true), ERROR(false);

        private final boolean success;

        Network(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }

    public enum Type {
        DEFAULT {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS.getState() : ERROR.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS.getMessage() : ERROR.getMessage()) : message;
            }
        },
        POST {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_POST.getState() : ERROR_POST.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_POST.getMessage() : ERROR_POST.getMessage()) : message;
            }
        },
        DELETE {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_DELETE.getState() : ERROR_DELETE.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_DELETE.getMessage() : ERROR_DELETE.getMessage()) : message;
            }
        },
        GET {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_GET.getState() : ERROR_GET.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_GET.getMessage() : ERROR_GET.getMessage()) : message;
            }
        },
        PUT {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_PUT.getState() : ERROR_PUT.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_PUT.getMessage() : ERROR_PUT.getMessage()) : message;
            }
        };

        Type() {
        }

        public abstract int getState(Network network, Integer state);

        public abstract String getMessage(Network network, String message);
    }
}
