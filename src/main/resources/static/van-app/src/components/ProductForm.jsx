import React, { Component } from 'react';

class ProductForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      image: '',
      name: '',
      description: '',
      price: 0,
      category: '',
      sold: false,
    };
  }

  // Add form input change handlers to update state
  handleInputChange = (event) => {
    const { name, value, type, checked } = event.target;
    const newValue = type === 'checkbox' ? checked : value;
    this.setState({ [name]: newValue });
  };

  // Handle form submission
  handleSubmit = (event) => {
    event.preventDefault();
    // You can perform actions with the form data here, e.g., submit to a server
    console.log(this.state);
  };

  render() {
    return (
      <div className="container mt-5">
        <h2>Product Form</h2>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="image">Image URL:</label>
            <input
              type="text"
              className="form-control"
              id="image"
              name="image"
              value={this.state.image}
              onChange={this.handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              className="form-control"
              id="name"
              name="name"
              value={this.state.name}
              onChange={this.handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="description">Description:</label>
            <textarea
              className="form-control"
              id="description"
              name="description"
              value={this.state.description}
              onChange={this.handleInputChange}
            ></textarea>
          </div>
          <div className="form-group">
            <label htmlFor="price">Price:</label>
            <input
              type="number"
              className="form-control"
              id="price"
              name="price"
              value={this.state.price}
              onChange={this.handleInputChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="category">Category:</label>
            <input
              type="text"
              className="form-control"
              id="category"
              name="category"
              value={this.state.category}
              onChange={this.handleInputChange}
            />
          </div>
          <div className="form-group form-check">
            <input
              type="checkbox"
              className="form-check-input"
              id="sold"
              name="sold"
              checked={this.state.sold}
              onChange={this.handleInputChange}
            />
            <label className="form-check-label" htmlFor="sold">
              Sold
            </label>
          </div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default ProductForm;
