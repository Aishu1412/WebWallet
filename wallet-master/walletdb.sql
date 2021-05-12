CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(20) NOT NULL,
  `qrid` int,
  PRIMARY KEY (qrid),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `wallet`(
id int not null auto_increment,
`cash` double NOT NULL,
uid int not null,
PRIMARY KEY( id),
KEY `wallet_uid` (`uid`),
CONSTRAINT `wallet_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`qrid`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `transactions`(
id int not null auto_increment,
`amount` double NOT NULL,
`comments` varchar(250) NOT NULL,
`time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`user` int NOT NULL,
PRIMARY KEY(`id`),
KEY `trans_uid` (`user`),
CONSTRAINT `trans_uid` FOREIGN KEY (`user`) REFERENCES `user` (`qrid`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;