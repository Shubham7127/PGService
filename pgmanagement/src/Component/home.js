import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';


const PropertyList = () => {
  const [properties, setProperties] = useState([]);
  const [cityName, setCityName] = useState(''); // State for city name input

  useEffect(() => {
    // Fetch properties by city name when the component mounts
    if (cityName) {
      axios.get("http://localhost:8080/properties/${cityName}")
        .then(response => {
            console.log(response.data);
          setProperties(response.data);
        })
        .catch(error => {
          console.error('Error fetching data:', error);
        });
    }
  }, [cityName]);

  return (
    <div>
      <h2>Property List</h2>
      <input
        type="text"
        placeholder="Enter city name"
        onChange={(e) => setCityName(e.target.value)}
      />
      <ul>
        {properties.map(property => (
          <li key={property.propertyid}>
            <Link to={`/property/${property.propertyid}`}>
              {property.propertyname}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};


export default PropertyList;