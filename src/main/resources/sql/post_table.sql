CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `content` varchar(140) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `dislikes` bigint(20) DEFAULT NULL,
  `likes` bigint(20) DEFAULT NULL,
  `image_url` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
