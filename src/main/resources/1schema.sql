INSERT INTO `validation`.`account` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES ('1', 'ali.abdalla@sabalGroup.com', 1, 'Ali', 'Abdalla', 'ali', 'ali');

INSERT INTO `validation`.`role` (`id`, `role_name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `validation`.`role` (`id`, `role_name`) VALUES ('2', 'ROLE_USER');

INSERT INTO `validation`.`accounts_roles` (`account_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `validation`.`accounts_roles` (`account_id`, `role_id`) VALUES ('1', '2');
