DROP TRIGGER IF EXISTS `product_catalog_db`.`TRG_PRODUCT_AFTER_INSERT`;
DELIMITER $$
USE `product_catalog_db`$$
CREATE DEFINER = CURRENT_USER TRIGGER `product_catalog_db`.`TRG_PRODUCT_AFTER_INSERT` AFTER INSERT ON `product` FOR EACH ROW
BEGIN
INSERT INTO product_history (product_id, product_code, product_name, product_price, product_type_id, created_date_time, created_by, operation) 
VALUES (new.product_id, new.product_code, new.product_name, new.product_price, new.product_type_product_type_id, new.created_date_time, new.created_by,'I');
END$$
DELIMITER ;


DROP TRIGGER IF EXISTS `product_catalog_db`.`TRG_PRODUCT_AFTER_UPDATE`;
DELIMITER $$
USE `product_catalog_db`$$
CREATE DEFINER = CURRENT_USER TRIGGER `product_catalog_db`.`TRG_PRODUCT_AFTER_UPDATE` AFTER UPDATE ON `product` FOR EACH ROW
BEGIN
INSERT INTO product_history (product_id, product_code, product_name, product_price, product_type_id, created_date_time, created_by, operation) VALUES (old.product_id, old.product_code, old.product_name, old.product_price, old.product_type_product_type_id, old.created_date_time, old.created_by,'U');
END$$
DELIMITER ;


DROP TRIGGER IF EXISTS `product_catalog_db`.`TRG_PRODUCT_AFTER_DELETE`;
DELIMITER $$
USE `product_catalog_db`$$
CREATE DEFINER = CURRENT_USER TRIGGER `product_catalog_db`.`TRG_PRODUCT_AFTER_DELETE` AFTER DELETE ON `product` FOR EACH ROW
BEGIN
INSERT INTO product_history (product_id, product_code, product_name, product_price, product_type_id, created_date_time, created_by, operation) VALUES (old.product_id, old.product_code, old.product_name, old.product_price, old.product_type_product_type_id, old.created_date_time, old.created_by,'D');
END$$
DELIMITER ;
