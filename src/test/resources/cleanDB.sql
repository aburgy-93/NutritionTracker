DROP TABLE IF EXISTS `food_tracker`;
DROP TABLE IF EXISTS `food_table`;
DROP TABLE IF EXISTS `food_user`;

CREATE TABLE `food_user` (
`id` int NOT NULL AUTO_INCREMENT,
`sub` varchar(255) NOT NULL,
`access_privileges` varchar(55) NOT NULL DEFAULT 'user',
`username` varchar(255) NOT NULL,
`email` varchar(50) DEFAULT NULL,
`birthDate` varchar(15) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `food_table` (
`id` int NOT NULL AUTO_INCREMENT,
`food_name` varchar(100) NOT NULL,
`food_type` varchar(25) DEFAULT NULL,
`serving_size` int NOT NULL,
`serving_name` varchar(10) NOT NULL,
`calories` int NOT NULL,
`fat` decimal(5,2) NOT NULL,
`carbs` decimal(5,2) NOT NULL,
`protein` decimal(5,2) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `food_tracker` (
`id` int NOT NULL AUTO_INCREMENT,
`user_id` int NOT NULL,
`food_id` int NOT NULL,
`date` date NOT NULL,
`serving_size` int NOT NULL,
`meal_time` varchar(50) NOT NULL,
`total_calories` double NOT NULL,
`total_protein` decimal(5,2) NOT NULL,
`total_carbs` decimal(5,2) NOT NULL,
`total_fat` decimal(5,2) NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`user_id`) REFERENCES `food_user` (`id`) ON DELETE CASCADE,
FOREIGN KEY (`food_id`) REFERENCES `food_table` (`id`) ON DELETE CASCADE
);

INSERT INTO `food_user` VALUES
                            (1,'b1db5510-d031-70b0-fe58-bf0ed1039f21','admin','aburgy','aburgy@madisoncollege.edu','1/01/1984'),
                            (2,'b1db5510-d031-70b0-fe58-bf0ed1039g25','user','rbobandy','randy@test.edu','4/20/1999');

INSERT INTO `food_table` VALUES
                             (1,'Chicken Breast','Meat',1,'Ounce',37,0.30,0.00,8.50),
                             (2,'White Rice','Grain',1,'Cup',242,0.40,53.00,4.30);

INSERT INTO `food_tracker`
(`user_id`, `food_id`, `date`, `serving_size`, `meal_time`, `total_calories`, `total_protein`, `total_carbs`, `total_fat`)
VALUES
    (1,1,'2025-02-15',5,'Lunch',185.0,43.0,0,2.0),
    (1,2,'2025-02-15',1,'Lunch',242.0,4.30,53.0,.40),
    (2,1,'2025-02-15',5,'Dinner',185.0,43.0,0,2.0);
