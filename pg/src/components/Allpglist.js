import React, { useEffect, useState } from "react";
import Pglist from "./Pglist";
import { ToastContainer, toast } from "react-toastify";
import axios from "axios";


const Allpglist = () =>
{
    useEffect(() => {
        getallpglistfromcity();
    },[]);

    const getallpglistfromcity =() => {
        axios.get(`http://localhost:8080/properties/list/delhi`).then(
           (response) =>{
            console.log(response.data);
            toast.success("successful loaded");
            setpglists(response.data)

           }, 
           (error) =>{
             console.log(error);
             toast.error("error");
           }
        ) ;
         
    }

    const [pglists,setpglists] = useState([
    

    ])
    return (
        <div>
            <h1>All pgs</h1>
             <p>List of all pgs from city</p>
           
            { pglists.length>0
                ? pglists.map((item) => <Pglist key ={item.id} pglist = {item } />)
                    :"No courses"}

                    
        </div>
    )
}

export default Allpglist;