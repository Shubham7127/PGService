import React, { useState } from 'react';
import axios from 'axios';
import './Prop.css'; // Import your CSS file


function PropertyForm() {
  // Define state variables to store input values
  const [Name, setName] = useState('');
  const [address, setAddress] = useState('');
  const [rent, setRent] = useState('');
  const [gender, setGender] = useState('');
  const [description, setDescription] = useState('');
  const [ratingClean, setRatingClean] = useState('');
  const [ratingFood, setRatingFood] = useState('');
  const [ratingSafety, setRatingSafety] = useState('');
  const [city_id, setCityid] = useState('');
  // Handle form submission
  const handleSubmit = (event) => {
    event.preventDefault();

    // Create an object to store the form data
    const formData = {
      Name,
      address,
      rent,
      gender,
      description,
      ratingClean,
      ratingFood,
      ratingSafety,
      city_id
    };

    // Send the form data to a server using Axios
    axios
      .post("http://localhost:8080/admin/property/addproperty", formData)
      .then((response) => {
        console.log('Form data submitted successfully:', response.data);
        // You can add further logic here for success, like displaying a success message or redirecting the user.
      })
      .catch((error) => {
        console.error('Error submitting form data:', error);
        // Handle any errors, such as displaying an error message to the user.
      });
  };

  return (
    <div className="container">
      <h2 className="mt-4">Property Information</h2>
      <form onSubmit={handleSubmit}>
      <div className="mb-3">
          <label htmlFor="Name" className="form-label">Name:</label>
          <input
            type="text"
            className="form-control"
            id="Name"
            value={Name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="address" className="form-label">Address:</label>
          <input
            type="text"
            className="form-control"
            id="address"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="rent" className="form-label">Rent:</label>
          <input
            type="text"
            className="form-control"
            id="rent"
            value={rent}
            onChange={(e) => setRent(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="gender" className="form-label">Gender:</label>
          <input
            type="text"
            className="form-control"
            id="gender"
            value={gender}
            onChange={(e) => setGender(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">Description:</label>
          <textarea
            className="form-control"
            id="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="ratingClean" className="form-label">Cleanliness Rating:</label>
          <input
            type="number"
            className="form-control"
            id="ratingClean"
            value={ratingClean}
            onChange={(e) => setRatingClean(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="ratingFood" className="form-label">Food Rating:</label>
          <input
            type="number"
            className="form-control"
            id="ratingFood"
            value={ratingFood}
            onChange={(e) => setRatingFood(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="ratingSafety" className="form-label">Safety Rating:</label>
          <input
            type="number"
            className="form-control"
            id="ratingSafety"
            value={ratingSafety}
            onChange={(e) => setRatingSafety(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="city_id" className="form-label">City_id:</label>
          <input
            type="text"
            className="form-control"
            id="city_id"
            value={city_id}
            onChange={(e) => setCityid(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
}

export default PropertyForm;
