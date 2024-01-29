import React, { useEffect, useState } from 'react';
import ProductForm from './ProductForm';
import ProductCard from './ProductCard';
import '../App.css';
import axios from 'axios';

function Home() {
  
  const [products, setProducts] = useState([]);
  const [showProductForm, setShowProductForm] = useState(false); // State to manage form visibility

  useEffect(() => {
    // Make an HTTP GET request to fetch product data
    axios
      .get('http://127.0.0.1:8080/product/list')
      .then((response) => {
        console.log(response.data);
        setProducts(response.data); // Assuming the API returns an array of product objects
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }, []); // Empty dependency array means this effect runs once on component mount

  const toggleProductForm = () => {
    setShowProductForm(!showProductForm); // Toggle the form visibility
  };

  return (
    <div className="App">
      <button onClick={toggleProductForm}>Toggle Product Form</button>
      {showProductForm && <ProductForm />} {/* Render the form if showProductForm is true */}
      {products.map((product, index) => (
        <ProductCard key={index} product={product} />
      ))}
    </div>
  );
}

export default Home;
