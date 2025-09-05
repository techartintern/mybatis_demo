-- Insert sample users
INSERT INTO app_user (first_name, last_name, username) VALUES
('John', 'Doe', 'john.doe'),
('Jane', 'Smith', 'jane.smith'),
('Bob', 'Johnson', 'bob.johnson');

-- Insert sample articles
INSERT INTO article (name, description, category, price, available_quantity) VALUES
('iPhone 15', 'Latest Apple smartphone', 'ELECTRONICS', 999.99, 50),
('Nike Air Max', 'Comfortable running shoes', 'CLOTHING', 129.99, 100),
('Clean Code', 'Book by Robert C. Martin', 'BOOKS', 39.99, 25),
('Coffee Maker', 'Automatic drip coffee maker', 'HOME', 89.99, 30),
('Tennis Racket', 'Professional tennis racket', 'SPORTS', 149.99, 15);