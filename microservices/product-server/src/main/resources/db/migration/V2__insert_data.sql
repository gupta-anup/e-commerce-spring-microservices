-- Insert dummy categories
INSERT INTO category (id, name, description)
VALUES
    (1, 'Electronics', 'Devices and gadgets'),
    (2, 'Books', 'Various kinds of books'),
    (3, 'Clothing', 'Apparel and fashion items'),
    (4, 'Home Appliances', 'Appliances for home use'),
    (5, 'Sports', 'Sports equipment and gear');

-- Insert dummy products
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (1, 'Smartphone', 'Latest model with 5G support', 50, 699.99, 1),
    (2, 'Laptop', 'Powerful laptop with 16GB RAM', 30, 1199.99, 1),
    (3, 'Wireless Headphones', 'Noise-cancelling over-ear headphones', 100, 199.99, 1),
    (4, 'Science Fiction Novel', 'Bestselling sci-fi book', 200, 15.99, 2),
    (5, 'T-Shirt', 'Cotton T-shirt with cool design', 150, 9.99, 3),
    (6, 'Microwave Oven', '800W digital microwave oven', 40, 129.99, 4),
    (7, 'Running Shoes', 'Lightweight and comfortable running shoes', 80, 59.99, 5);
