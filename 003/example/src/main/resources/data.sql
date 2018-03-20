INSERT INTO TB_DICT (ID, PID, LEVEL, IDENT, DATA, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES (1L, 0L, '0', 'ROLE', '用户类型', '默认数据', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_DICT (ID, PID, LEVEL, IDENT, DATA, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES (2L, 0L, '0', 'SEX', '性别', '默认数据', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_DICT (ID, PID, LEVEL, IDENT, DATA, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES (3L, 1L, '0.1', 'ROLE.1', '管理者', '默认数据', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_DICT (ID, PID, LEVEL, IDENT, DATA, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES (4L, 1L, '0.1', 'ROLE.2', '使用者', '默认数据', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_DICT (ID, PID, LEVEL, IDENT, DATA, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES (5L, 2L, '0.2', 'SEX.1', '男', '默认数据', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_DICT (ID, PID, LEVEL, IDENT, DATA, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES (6L, 2L, '0.2', 'SEX.2', '女', '默认数据', 'SYSTEM', 'SYSTEM');

INSERT INTO TB_AUTHORITY (NAME, IDENT, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES ('ROLE_ADMIN', 'ROLE.1', '系统管理员', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_AUTHORITY (NAME, IDENT, DESCRIBE, CREATED_BY, LAST_MODIFIED_BY) VALUES ('ROLE_USER', 'ROLE.2', '普通用户', 'SYSTEM', 'SYSTEM');

INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (1L, 0L, '0', '功能1', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (2L, 0L, '0', '功能2', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (3L, 0L, '0', '功能3', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (4L, 0L, '0', '功能4', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (5L, 1L, '0.1', '功能1.1', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (6L, 1L, '0.1', '功能1.2', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (7L, 2L, '0.2', '功能2.1', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (8L, 3L, '0.3', '功能3.1', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (9L, 4L, '0.4', '功能4.1', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (10L, 4L, '0.4', '功能4.2', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (11L, 4L, '0.4', '功能4.3', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_PERMISSIONS (ID, PID, LEVEL, NAME, CREATED_BY, LAST_MODIFIED_BY) VALUES (12L, 5L, '0.1.5', '功能1.1.1', 'SYSTEM', 'SYSTEM');

INSERT INTO TB_USER (ID, USERNAME, PASSWORD, CREATED_BY, LAST_MODIFIED_BY) VALUES (1L, 'system', '123456', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_USER (ID, USERNAME, PASSWORD, CREATED_BY, LAST_MODIFIED_BY) VALUES (2L, 'admin', '123456', 'SYSTEM', 'SYSTEM');
INSERT INTO TB_USER (ID, USERNAME, PASSWORD, CREATED_BY, LAST_MODIFIED_BY) VALUES (3L, 'user', '123456', 'SYSTEM', 'SYSTEM');

INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (1L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (2L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (3L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (3L, 'ROLE_USER');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (4L, 'ROLE_USER');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (5L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (6L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (7L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (8L, 'ROLE_ADMIN');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (8L, 'ROLE_USER');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (9L, 'ROLE_USER');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (10L, 'ROLE_USER');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (11L, 'ROLE_USER');
INSERT INTO TB_PERMISSIONS_AUTHORITY (PERMISSIONS_ID, AUTHORITY_NAME) VALUES (12L, 'ROLE_ADMIN');

INSERT INTO TB_USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (1L, 'ROLE_ADMIN');
INSERT INTO TB_USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (1L, 'ROLE_USER');
INSERT INTO TB_USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (2L, 'ROLE_ADMIN');
INSERT INTO TB_USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (3L, 'ROLE_USER');
