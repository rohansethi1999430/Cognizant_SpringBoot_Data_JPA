use truyum;

TRUNCATE menu_item;

INSERT INTO menu_item (me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery) VALUES ("Sandwich", 99.00, "YES", DATE("2017-03-15"), "Main Course", "YES");
INSERT INTO menu_item (me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery) VALUES ("Burger", 129.00, "YES", DATE("2017-12-23"), "Main Course", "NO");
INSERT INTO menu_item (me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery) VALUES ("Pizza", 149.00, "YES", DATE("2018-08-21"), "Main Course", "NO");
INSERT INTO menu_item (me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery) VALUES ("French Fries", 57.00, "NO", DATE("2017-07-02"), "Starters", "YES");
INSERT INTO menu_item (me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery) VALUES ("Chocolate Brownie", 32.00, "YES", DATE("2022-11-02"), "Dessert", "YES");

select * from menu_item;
