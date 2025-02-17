-- Insert dummy categories
INSERT INTO category (name, description)
    VALUES
        ('Electronics', 'Electronic gadgets and devices'),
        ('Books', 'Collection of various books'),
        ('Clothing', 'Men and women clothing');

-- Insert dummy products
INSERT INTO product (name, description, available_quantity, price, category_id)
    VALUES
        ('Smartphone', 'Latest Android smartphone', 50, 699.99, 1),
        ('Laptop', 'High performance laptop', 30, 1200.50, 1),
        ('Fiction Book', 'Bestselling fiction book', 100, 19.99, 2),
        ('T-Shirt', 'Cotton t-shirt', 200, 9.99, 3),
        ('Jeans', 'Denim blue jeans', 150, 39.99, 3);
