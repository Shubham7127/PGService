import React from "react";
import { Card , CardBody ,CardTitle , CardSubtitle ,CardText,CardFooter,Button,Container } from "reactstrap";
import prop1 from "../assets/properties/1/1d4f0757fdb86d5f.jpg";
import PropertyDetail from "./PropertyDetail";
import { useState } from "react";
import { useNavigate,Link } from "react-router-dom";




const Pglist =(props) =>
{
    const{pglist} =props
    const [pid, setpid] = useState('');
    const navigate=useNavigate()
  

    const handleButtonClick = (data) => {
        console.log('id', data);
        sessionStorage.setItem("id",data);
        navigate("/PropertyDetail",{ state :{ pid: data}})
      };

 
    const pglistinfo=(e)=>{
        setpid(e);
        console.log(e.id);
     //navigate("/PropertyDetail",{ state :{ pid: id}})
    }


    const handleChange = (event) => {
        const newValue = event.target.value;
        setpid(newValue);
        console.log(pid);
       // <Pglist key ={item.id} pglist = {item } />
       <PropertyDetail key={pid}/>
        };


    return (
        <Card className="text-center">
            <CardBody>
            
                    <Container className="text-center">
                
                       
                    </Container>

                    <div class="property-card row">
            <div class="image-container col-md-4">
                <img src={prop1} />
            </div>
            <div class="content-container col-md-8">
                <div class="row no-gutters justify-content-between">
                    <div class="star-container" title="4.5">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star-half-alt"></i>
                    </div>
                    {/* <div class="interested-container">
                        <i class="far fa-heart"></i>
                        <div class="interested-text">3 interested</div>
                    </div> */}
                </div>
                <div class="detail-container">
                    <div class="property-name"> <CardSubtitle> {pglist.name} </CardSubtitle></div>
                    <div class="property-address"> <CardText>{pglist.description}</CardText></div>
                    <CardText>{pglist.address}</CardText>
                    <div class="property-gender">
                    <CardText>{pglist.gender}</CardText>
                    {pglist.id}
                        {/* <img src="img/male.png" /> */}
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="rent-container col-6">
                        <div class="rent"><CardText>Rs{pglist.rent}/-</CardText></div>
                        <div class="rent-unit">per month</div>
                    </div>
                    <div class="button-container col-6" >
                        {/* <a href="/PropertyDetail" class="btn btn-primary">View</a> */}
                       
                         {/* <button  onClick={ () => handleChange(pglist.id)}>Viewmy</button> */}
    
                        {/* <button onClick={pglistinfo}>View   </button> */}

                       <button  class="btn btn-primary" onClick={ () => handleButtonClick(pglist.id)}>View</button>
                        {/* <button onClick={ (e) => pglistinfo(e)}>View   </button> */}
                        {/* <button onClick={() => handleChange(pglist.id)}></button> */}

                      
                    </div>
                </div>
            </div>
        </div>
        <br></br>
        <br></br>
               
            </CardBody> 
        </Card>
    )
}

export default Pglist;