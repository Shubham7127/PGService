import React, { useEffect, useState } from "react";
import logomy from "../../assets/mylogo.png";
import { Navigate } from "react-router-dom";

const Navbar = () => {
  const [showLink, setShowLink] = useState(false);
  const [refresh, setRefresh]=useState(true);

  const logoutUser = () => {
    sessionStorage.removeItem('id');
    sessionStorage.removeItem('isUserLoggedIn');
    setShowLink(false);
    Navigate('/Signin');
  }

  useEffect(() => {
    setShowLink(sessionStorage.getItem('isUserLoggedIn'));
    if(refresh){
    // window.location.reload();
      setRefresh(false);
    }
  }, [setRefresh]);

  return (
    <nav className="navbar navbar-expand-lg fixed-top" style={{ zIndex: 100 }}>
      <a className="navbar-brand" href="/"><img src={logomy} className="city-img1" /></a>
      <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <a href='/Contactus' className='btn btn-outline-light ms-2'>
              <i className='fa fa-user-plus me-1 '></i>
              Contactus
       </a>
       <a href='/Home' className='btn btn-outline-light ms-2'>
              <i className='fa fa-user-plus me-1 '></i>
              Home
            </a>
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav ml-auto"> {/* Use ml-auto to push the items to the right */}
{/*            
          {showLink ? (
            <div>
            <li className="nav-item dropdown">
              <button className= "btn btn-outline-light " type="button"  >
                <b>
               <i  className="fa fa-user me-1"></i>
               {sessionStorage.getItem('Name')}</b>
              </button>
              <ul className="dropdown-menu">
                <li><a className="dropdown-item" href="/logout" onClick={() => logoutUser()}>Logout</a></li>
              </ul>
            </li>
            </div>
          ) : (
            <li className="nav-item">
              <a href='/Signin' className='btn btn-outline-light ms-2'>
                <i className='fa fa-sign-in me-1'></i>
                Login
              </a>
            </li>
          )} */}
              {showLink ? (
                                   <div class="dropdown" >
                                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                               <b> <i className='fa fa-user me-1'></i>
                                                {sessionStorage.getItem('Name')}</b>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="/logout" onClick={() => logoutUser()}>Logout</a></li>

                                            </ul>
                                        </div>)
                                    : (
                                        <a href='/Signin' className='btn btn-outline-light'>
                                            <i className='fa fa-sign-in me-1'></i>
                                            Login
                                        </a>
                                    )}&nbsp;&nbsp;

          {showLink ? (
            <li className="nav-item">
            
                <a href='/logout' className='btn btn-outline-light ms-2' onClick={() => logoutUser()}>
                <i className='fa fa-sign-out me-1'></i>
                Logout
              </a>
            </li>
          ) : (
            <li className="nav-item">
              <a href='/Signup' className='btn btn-outline-light ms-2' > {/*  ms-2 ne button madhe space yeto */}
                <i className='fa fa-user-plus me-1'></i>
                Register
              </a>
            </li>
          )}
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
