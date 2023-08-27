import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { ToastContainer, toast } from "react-toastify";
import Pglist from './Pglist';
import "../css/common.css";
import "../css/property_list.css";
import { useParams } from 'react-router-dom';


const Delhi = () => {    
  const [pglists,setpglists] = useState([]);
 
  const{cityName} = useParams();
  //console.log(window.location.pathname);

  var uri=window.location.pathname
  
  useEffect(() => {
    getallpglistfromcity();
  },[]);

  const getallpglistfromcity =() => {
     axios.get(`http://localhost:8080/properties/list/`+cityName).then(
     
       (response) =>{
        console.log(response.data);
       
        setpglists(response.data)

       }, 
       (error) =>{
         console.log(error);
         
       }
    ) ;
     
}

  
  

   return (

<div className="container">

      <h1 className="text-center">Property Listings</h1>
      <br></br>
       
        <div>   
            { pglists.length>0
                ? pglists.map((item) => <Pglist key ={item.id} pglist = {item } />)
                    :"No courses"}       
        </div>

    </div>
  );
};

export default Delhi;