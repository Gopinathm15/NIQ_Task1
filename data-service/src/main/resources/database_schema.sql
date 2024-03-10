-- niq_db.product_info definition

CREATE TABLE `product_info` (
  `product_id` varchar(255) NOT NULL,
  `brand` varchar(255) default NULL,
  `category` varchar(255) default NULL,
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- niq_db.relevancy_info_seq definition

CREATE TABLE `relevancy_info_seq` (
  `next_val` bigint(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- niq_db.shopper_info definition

CREATE TABLE `shopper_info` (
  `shopper_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`shopper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- niq_db.relevancy_info definition

CREATE TABLE `relevancy_info` (
  `id` bigint(20) NOT NULL,
  `score` decimal(38,2) default NULL,
  `product_id` varchar(255) NOT NULL,
  `shopper_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKsd1g5rm9fay85u0bs460xjnss` (`product_id`),
  KEY `FK1c4xth85tq11k96swojn64epp` (`shopper_id`),
  CONSTRAINT `FK1c4xth85tq11k96swojn64epp` FOREIGN KEY (`shopper_id`) REFERENCES `shopper_info` (`shopper_id`),
  CONSTRAINT `FKsd1g5rm9fay85u0bs460xjnss` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;