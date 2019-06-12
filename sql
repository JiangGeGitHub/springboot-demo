SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


INSERT INTO `city` VALUES (1, '北京');
INSERT INTO `city` VALUES (3, '山东');
INSERT INTO `city` VALUES (4, '杭州');
INSERT INTO `city` VALUES (5, '上海');
INSERT INTO `city` VALUES (20, '深圳');
INSERT INTO `city` VALUES (51, '深圳3');
INSERT INTO `city` VALUES (52, '广州');
INSERT INTO `city` VALUES (54, '新疆');
INSERT INTO `city` VALUES (56, '澳门');
INSERT INTO `city` VALUES (58, '台湾');
INSERT INTO `city` VALUES (59, '江苏');

SET FOREIGN_KEY_CHECKS = 1;


DROP TABLE IF EXISTS `city_weather`;
CREATE TABLE `city_weather`  (
  `city_id` int(11) NOT NULL COMMENT '城市id',
  `weather` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '天气',
  `date` datetime(0) NOT NULL COMMENT '日期'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of city_weather
-- ----------------------------
INSERT INTO `city_weather` VALUES (1, '晴', '2019-06-11 16:53:38');
INSERT INTO `city_weather` VALUES (1, '阴', '2019-06-10 16:53:41');

SET FOREIGN_KEY_CHECKS = 1;
