/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50627
 Source Host           : localhost
 Source Database       : book

 Target Server Type    : MySQL
 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 01/01/2020 09:48:40 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` char(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `book`
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES ('1', '楊偉', '這是一本小說,不錯。 推薦你閱讀', '我們', '1'),
						  ('2', '劉慈欣', '一本科幻小說', '時間移民', '2'),

                          ('4', '簡·麥戈尼格爾 ', '遊戲是我們集中精力的大好機會,我們樂觀向上地做著一件自己擅長並享受的事情', '遊戲改變世界', '0'),
                          ('5', '彼得·蒂爾 / 布萊克·馬斯特斯 ', '説明你思考從0到1的秘密,在意想不到之處發現價值與機會', '從0到1', '2'),
                          ('6', '[美] 德內拉·梅多斯 ', '是一本簡明扼要的系統思考入門指南, 也是認識複雜動態系統的有力工具', '系統之美', '1'),
                          ('7', '彼得•邁爾斯 (Peter Meyers) / 尚恩•尼克', '通過演講一舉贏得支援實現夢想', '高效演講', '0'),
                          ('8', '凱文·凱利', '經濟和社會發展的趨勢有著深刻的見解', '必然', '2'),
                          ('9', '凱文·凱利', '這可能是90年代最重要的一本書', '失控', '1'),
                          ('10', '李笑來', '時間管理不了,只能管理自己', '把時間當作朋友', '2'),
                          ('11', '李笑來', '七年就是一輩子', '七年就是一輩子', '1'),
                          ('12', '王東嶽', '一本哲理隨筆,彙集了作者數十年的思想精髓。 哲學', '知魚之樂', '0'),
                          ('13', '王東嶽', '一本哲學書', '物演通論', '0'),
                          ('14', '查理·芒格', '收錄了查理•芒格的個人傳記與投資哲學', '窮查理寶典', '1'),
                          ('15', 'Andy Hunt ', '思考如何解決問題', '程式師思維修煉', '2'),
                          ('16', 'Andy Hunt ', '學有所思,思有所悟,悟有所行', '高效程式師的45個習慣', '1'),
                          ('17', '格雷厄姆', ' 主要介紹駭客即優秀程式師的愛好和動機', '駭客與畫家', '0'),
                          ('18', '安德斯•艾利克森', '如何學習一項技能的方法', '刻意練習', '2'),
                          ('19', '李善友', '關於創業的方法論', '創業方法論', '1'),
                          ('20', '李笑來', '這是一本不錯的書', '和時間做朋友', '0'),
                          ('21', '張三', '我隨便寫的一個書', '私生活', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
