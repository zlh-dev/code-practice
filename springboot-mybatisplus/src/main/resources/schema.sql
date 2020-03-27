-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.16 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- --------------------------------------------------------

-- 表 administrative_divisions.areas 结构
DROP TABLE IF EXISTS `areas`;
CREATE TABLE IF NOT EXISTS `areas`
(
    `code`         bigint(12)                                                   NOT NULL COMMENT '统计用区划代码',
    `name`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    `cityCode`     bigint(12)                                                   NOT NULL COMMENT '地级区划代码',
    `provinceCode` bigint(12)                                                   NOT NULL COMMENT '省级区划代码',
    `deleted`      TINYINT(1) UNSIGNED ZEROFILL                                 NOT NULL DEFAULT '0' COMMENT '删除标记',
    PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='县级（区县）';

-- 表 administrative_divisions.cities 结构
DROP TABLE IF EXISTS `cities`;
CREATE TABLE IF NOT EXISTS `cities`
(
    `code`         bigint(12)                                                   NOT NULL COMMENT '统计用区划代码',
    `name`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    `provinceCode` bigint(12)                                                   NOT NULL COMMENT '省级区划代码',
    `deleted`      TINYINT(1) UNSIGNED ZEROFILL                                 NOT NULL DEFAULT '0' COMMENT '删除标记',
    PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='地级（城市）';

-- 表 administrative_divisions.provinces 结构
DROP TABLE IF EXISTS `provinces`;
CREATE TABLE IF NOT EXISTS `provinces`
(
    `code`    bigint(12)                                                   NOT NULL COMMENT '统计用区划代码',
    `name`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    `deleted` TINYINT(1) UNSIGNED ZEROFILL                                 NOT NULL DEFAULT '0' COMMENT '删除标记',
    PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='省级（省份直辖市自治区）';

-- 表 administrative_divisions.streets 结构
DROP TABLE IF EXISTS `streets`;
CREATE TABLE IF NOT EXISTS `streets`
(
    `code`         bigint(12)                                                   NOT NULL COMMENT '统计用区划代码',
    `name`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    `areaCode`     bigint(12)                                                   NOT NULL COMMENT '县级区划代码',
    `cityCode`     bigint(12)                                                   NOT NULL COMMENT '地级区划代码',
    `provinceCode` bigint(12)                                                   NOT NULL COMMENT '省级区划代码',
    `deleted`      TINYINT(1) UNSIGNED ZEROFILL                                 NOT NULL DEFAULT '0' COMMENT '删除标记',
    PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='乡级（乡镇街道）';

-- 表 administrative_divisions.villages 结构
DROP TABLE IF EXISTS `villages`;
CREATE TABLE IF NOT EXISTS `villages`
(
    `code`         bigint(12)                                                   NOT NULL COMMENT '统计用区划代码',
    `name`         varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
    `streetCode`   bigint(12)                                                   NOT NULL COMMENT '乡级区划代码',
    `areaCode`     bigint(12)                                                   NOT NULL COMMENT '县级区划代码',
    `cityCode`     bigint(12)                                                   NOT NULL COMMENT '地级区划代码',
    `provinceCode` bigint(12)                                                   NOT NULL COMMENT '省级区划代码',
    `deleted`      TINYINT(1) UNSIGNED ZEROFILL                                 NOT NULL DEFAULT '0' COMMENT '删除标记',
    PRIMARY KEY (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='村级（村委会居委会）';

/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
