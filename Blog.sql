CREATE DATABASE blog;
USE blog;

CREATE TABLE role (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
)ENGINE=InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE user (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    id_role INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_role) REFERENCES role(id)
)ENGINE=InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE category (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
)ENGINE=InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE post (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(75) NOT NULL,
    content TEXT,
    create_at DATETIME,
    update_at DATETIME,
    is_active TINYINT,
    id_category INT UNSIGNED,
    id_user INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_category) REFERENCES category(id),
    FOREIGN KEY (id_user) REFERENCES user(id)
)ENGINE=InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE tag (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
)ENGINE=InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE post_tag (
    id_post INT UNSIGNED NOT NULL,
    id_tag INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_post, id_tag),
    FOREIGN KEY (id_post) REFERENCES post(id),
    FOREIGN KEY (id_tag) REFERENCES tag(id)
)ENGINE=InnoDB;

INSERT INTO role(id, name)
VALUES(1, "User"),
      (2, "Admin");

INSERT INTO user(id, firstname, lastname, email, password, id_role)
VALUES(1, "Nguyen", "Van A", "nguyenvana@gmail.com", "acmksm#^&%#%387", 1),
      (2, "Nguyen", "Van B", "nguyenvanb@gmail.com", "acmksm#^&%#%387", 2);

INSERT INTO category(id, name)
VALUES(1, "Khoa học"),
      (2, "Đời sống"),
      (3, "Công nghệ");

INSERT INTO post(id, title, content, createAt, updateAt, isActive, id_category, id_user)
VALUES(1, "Iphone 13 ra mắt", "Nghe Đồn Là: iPhone 13 (iPhone 12s) được trang bị sạc ngược không dây",
            "2020-01-01 21:32:10", "2020-01-01 21:32:10", 0, 3, 1),
      (2, "Hưu cao cổ có cổ cao", "Hưu cao cổ là loài động vật có cổ dài nhất",
            "2020-01-01 21:32:10", "2020-01-01 21:32:10", 1, 1, 2);

INSERT INTO tag(id, name)
VALUES(1, "Hưu cao cổ"),
      (2, "Iphone"),
      (3, "Sạc không dây");

INSERT INTO post_tag(id_post, id_tag)
VALUES(1, 2),
      (2, 2),
      (2, 3);