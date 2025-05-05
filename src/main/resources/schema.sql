CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    price DOUBLE,
    description TEXT
);


CREATE TABLE claims (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    businessName VARCHAR(100),
    orderNumber BIGINT,
    returnReason VARCHAR(100),
    claimStatus VARCHAR(100),
    preferredResolution VARCHAR(250),
    businessResponse VARCHAR(100),
    approvedResolutionType VARCHAR(100),
    returnInstructions VARCHAR(100),
    claimActive BOOLEAN
);

CREATE TABLE warranties (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    warrantyName VARCHAR(100),
    warrantyDesc VARCHAR(250),
    productCategory VARCHAR(100),
    restockFees DECIMAL,
    email VARCHAR(250),
    phoneNumber VARCHAR(20),
    returnInstructions VARCHAR(250),
    expirationDate BIGINT
);