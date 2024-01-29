import React from 'react';

const ProductCard = ({ product }) => {
  const { image, name, description, price, category, sold } = product;

  return (
    <div className="product-card">
      <img src={image} alt={name} />
      <h3>{name}</h3>
      <p>{description}</p>
      <p>Price: ${price}</p>
      <p>Category: {category}</p>
      {sold ? <p>Status: Sold</p> : <p>Status: Available</p>}
    </div>
  );
};

export default ProductCard;