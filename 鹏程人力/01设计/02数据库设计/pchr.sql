/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : pchr

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 13/07/2022 18:43:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for day_attend
-- ----------------------------
DROP TABLE IF EXISTS `day_attend`;
CREATE TABLE `day_attend`  (
  `attend_id` int NOT NULL AUTO_INCREMENT COMMENT '打卡id',
  `emp_id` int NULL DEFAULT NULL COMMENT '员工id',
  `supp_emp_id` int NULL DEFAULT NULL,
  `attend_state` int NULL DEFAULT NULL COMMENT '打卡状态（1:正常;2:迟到;3:早退;4:补卡）',
  `attend_time` datetime NULL DEFAULT NULL COMMENT '打卡时间',
  `supp_time` datetime NULL DEFAULT NULL COMMENT '补卡时间',
  PRIMARY KEY (`attend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工打卡表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dep_id` int NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `dep_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dep_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门编号',
  `remark` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `dep_state` int NULL DEFAULT NULL COMMENT '部门状态:1:正常;9:停用',
  `create_user_id` int NULL DEFAULT NULL COMMENT '创建人id',
  `modify_user_id` int NULL DEFAULT NULL COMMENT '修改人id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dep_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `emp_id` int NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `emp_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工名',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `emp_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工编号',
  `sex` int NULL DEFAULT NULL COMMENT '性别',
  `mobile` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `emp_state` int NULL DEFAULT NULL COMMENT '员工状态:1:正常;9:停用',
  `dep_id` int NULL DEFAULT NULL COMMENT '部门id',
  `job_id` int NULL DEFAULT NULL COMMENT '职务id',
  `remark` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `salary` int NULL DEFAULT NULL COMMENT '薪水',
  `homeplace` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建人id',
  `modify_emp_id` int NULL DEFAULT NULL COMMENT '修改人id',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `emp_head` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '员工头像',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `home_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `contact_man` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '紧急联系人电话',
  `relation` int NULL DEFAULT NULL COMMENT '紧急联系人关系',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号码',
  `wechart` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信号码',
  `seat_code` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工位编号',
  `id_card` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for emp_contract
-- ----------------------------
DROP TABLE IF EXISTS `emp_contract`;
CREATE TABLE `emp_contract`  (
  `contract_id` int NOT NULL AUTO_INCREMENT COMMENT '合同ID',
  `emp_id` int NULL DEFAULT NULL COMMENT '所属员工ID',
  `temp_id` int NULL DEFAULT NULL COMMENT '合同模板ID',
  `contract_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`contract_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工劳动合同表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for emp_leave
-- ----------------------------
DROP TABLE IF EXISTS `emp_leave`;
CREATE TABLE `emp_leave`  (
  `leave_id` int NOT NULL AUTO_INCREMENT COMMENT '请假表ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '截止时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请假原因',
  `emp_id` int NULL DEFAULT NULL COMMENT '员工ID',
  `apply_state` int NULL DEFAULT NULL,
  `apply_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `leave_type` int NULL DEFAULT NULL COMMENT '请假类型(1:事假;2:病假:3:年假;4:丧家;5:调休;6:调休)',
  `destory_state` int NULL DEFAULT NULL COMMENT '销假状态(1:未销假;2:已销假)',
  `destory_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`leave_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工请假表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for emp_memo
-- ----------------------------
DROP TABLE IF EXISTS `emp_memo`;
CREATE TABLE `emp_memo`  (
  `memo_id` int NOT NULL AUTO_INCREMENT COMMENT '备忘录id',
  `memo_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备忘录编号',
  `memo_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备忘录名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备忘录内容',
  `emp_id` int NULL DEFAULT NULL COMMENT '员工ID',
  PRIMARY KEY (`memo_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工备忘录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for emp_resume
-- ----------------------------
DROP TABLE IF EXISTS `emp_resume`;
CREATE TABLE `emp_resume`  (
  `resume_id` int NOT NULL AUTO_INCREMENT COMMENT '简历ID',
  `emp_id` int NULL DEFAULT NULL COMMENT '所属员工ID',
  `resume_file_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简历文件路径',
  `upload_time` datetime NULL DEFAULT NULL COMMENT '上传时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `upload_emp_id` int NULL DEFAULT NULL COMMENT '上传员工ID',
  `file_type` int NULL DEFAULT NULL COMMENT '简历文件类型(1:docx;2:pdf)',
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工简历表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `job_id` int NOT NULL AUTO_INCREMENT COMMENT '职务id',
  `job_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职务名称',
  `job_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职务编号',
  `remark` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建人id',
  `modify_emp_id` int NULL DEFAULT NULL COMMENT '修改人id',
  `dep_id` int NULL DEFAULT NULL COMMENT '所属部门',
  `job_state` int NULL DEFAULT NULL COMMENT '职务状态:1:正常;9:停用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门职务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for leave_approve
-- ----------------------------
DROP TABLE IF EXISTS `leave_approve`;
CREATE TABLE `leave_approve`  (
  `leave_approve_id` int NOT NULL AUTO_INCREMENT COMMENT '请假审批表ID',
  `approve_time` datetime NULL DEFAULT NULL COMMENT '审批时间',
  `approve_state` int NULL DEFAULT NULL COMMENT '审批状态:(1:同意;2:未同意;3:未处理;4:已取消)',
  `remark` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `apply_emp_id` int NULL DEFAULT NULL COMMENT '审批人ID',
  `apply_trans_no` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批流水(备用)',
  `trans_no_id` int NULL DEFAULT NULL COMMENT '交易ID',
  `leave_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请假ID',
  PRIMARY KEY (`leave_approve_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工请假审批表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_code` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公告编号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `type` int NULL DEFAULT NULL COMMENT '类型:(1:消息;2:公告)',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `release_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `release_emp_id` int NULL DEFAULT NULL COMMENT '发布员工ID',
  `state` int NULL DEFAULT NULL COMMENT '状态(1:有效;2:过期:3:停用)',
  `start_time` datetime NULL DEFAULT NULL COMMENT '生效时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice_emp
-- ----------------------------
DROP TABLE IF EXISTS `notice_emp`;
CREATE TABLE `notice_emp`  (
  `notice_emp_id` int NOT NULL AUTO_INCREMENT COMMENT '公告员工表ID',
  `notice_id` int NULL DEFAULT NULL COMMENT '公告ID',
  `emp_id` int NULL DEFAULT NULL COMMENT '员工ID',
  `read_state` int NULL DEFAULT NULL COMMENT 'read_state(1:未读;2:已读)',
  PRIMARY KEY (`notice_emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '公告员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contract_template
-- ----------------------------
DROP TABLE IF EXISTS `contract_template`;
CREATE TABLE `contract_template`  (
  `temp_id` int NOT NULL AUTO_INCREMENT COMMENT '模板ID',
  `temp_name`  varchar(100) COMMENT '模板名称',
  `temp_file_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模板文件路径',
  `temp_type` int NULL DEFAULT NULL COMMENT '模板类型(1:试用期;2:正式;3:终身;4:临时)',
  `temp_state` int NULL DEFAULT NULL COMMENT '模板状态(1:未使用;2:使用中;3:已停用)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建人ID',
  `modify_emp_id` int NULL DEFAULT NULL COMMENT '修改人ID',
  PRIMARY KEY (`temp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '合同模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `dict_id` int NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `dict_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典名称',
  `dict_code` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典代码',
  `p_dict_id` int NULL DEFAULT NULL COMMENT '父字典ID',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '添加人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `modify_emp_id` int NULL DEFAULT NULL COMMENT '修改人ID',
  `use_state` int NULL DEFAULT NULL COMMENT '使用状态(1:使用;2:停用)',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单url',
  `logo_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单logo url',
  `logo_base64` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '菜单logo base64编码',
  `menu_level` int NULL DEFAULT NULL COMMENT '菜单级别',
  `menu_index` int NULL DEFAULT NULL COMMENT '菜单索引',
  `p_menu_id` int NULL DEFAULT NULL COMMENT '父菜单id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建用户id',
  `modify_emp_id` int NULL DEFAULT NULL COMMENT '修改用户id',
  `use_state` int NULL DEFAULT NULL COMMENT '使用状态(1:使用;0:停用)',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name_zh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色中文名称',
  `role_name_en` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色英文名称',
  `sys_id` int NULL DEFAULT NULL COMMENT '系统id',
  `module_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模块名称',
  `max_count` int NULL DEFAULT NULL COMMENT '数量上限(0:没有上限)',
  `use_state` int NULL DEFAULT NULL COMMENT '使用状态(1:使用中;0:已停用)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建用户id',
  `modify_emp_id` int NULL DEFAULT NULL COMMENT '修改用户id',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_menu_id` int NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `menu_id` int NULL DEFAULT NULL COMMENT '菜单id(外键)',
  `role_id` int NULL DEFAULT NULL COMMENT '角色id(外键)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建用户id(外键)',
  PRIMARY KEY (`role_menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统角色菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_role_id` int NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id(外键)',
  `role_id` int NULL DEFAULT NULL COMMENT '角色id(外键)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_emp_id` int NULL DEFAULT NULL COMMENT '创建用户id(外键)',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for work_apply
-- ----------------------------
DROP TABLE IF EXISTS `work_apply`;
CREATE TABLE `work_apply`  (
  `apply_id` int NOT NULL AUTO_INCREMENT COMMENT '申请id',
  `emp_id` int NULL DEFAULT NULL COMMENT '申请人id(外键)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `apply_state` int NULL DEFAULT NULL COMMENT '申请状态(1:未处理;2:已通过3:未通过;4:已取消)',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `overtime_type` int NULL DEFAULT NULL COMMENT '加班类型',
  `cost_type` int NULL DEFAULT NULL COMMENT '加班费计算方式',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '申请备注',
  `appr_emp_id` int NULL DEFAULT NULL COMMENT '审批人ID',
  PRIMARY KEY (`apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工加班申请表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
