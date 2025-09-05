-- Create ENUM types
CREATE TYPE category_enum AS ENUM ('ELECTRONICS', 'CLOTHING', 'BOOKS', 'HOME', 'SPORTS', 'OTHER');
CREATE TYPE order_status_enum AS ENUM ('PENDING', 'CONFIRMED', 'SHIPPED', 'DELIVERED', 'CANCELLED');

-- Create AppUser table
CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Article table
CREATE TABLE article (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    category category_enum NOT NULL,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    available_quantity INTEGER NOT NULL DEFAULT 0 CHECK (available_quantity >= 0),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Order table
CREATE TABLE "order" (
    id BIGSERIAL PRIMARY KEY,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ordered_by BIGINT NOT NULL,
    status order_status_enum NOT NULL DEFAULT 'PENDING',
    total_amount DECIMAL(10, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ordered_by) REFERENCES app_user(id) ON DELETE CASCADE
);

-- Create OrderItem table
CREATE TABLE order_item (
    id BIGSERIAL PRIMARY KEY,
    article_id BIGINT NOT NULL,
    ordered_quantity INTEGER NOT NULL CHECK (ordered_quantity > 0),
    unit_price DECIMAL(10, 2) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);

-- Create OrderOrderItem junction table
CREATE TABLE order_order_item (
    order_id BIGINT NOT NULL,
    order_item_id BIGINT NOT NULL,
    PRIMARY KEY (order_id, order_item_id),
    FOREIGN KEY (order_id) REFERENCES "order"(id) ON DELETE CASCADE,
    FOREIGN KEY (order_item_id) REFERENCES order_item(id) ON DELETE CASCADE
);
