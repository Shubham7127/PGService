import { useState } from "react";
import { useNavigate } from "react-router";
import { ToastContainer ,toast } from "react-toastify";
import axios from "axios";
import "./signin.css";
import { Link } from "react-router-dom";
import { useLocation } from "react-router-dom";

const Signin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const location=useLocation();
  const navigate = useNavigate();

  const signinPerson = () => {
    if (email.length == 0)
     {
      toast.warning("please enter email");
     } else if (password.length == 0) 
     {
      toast.warning("please enter password");
    }
     else
      {
       const body = {
        email,
        password,
       };

           // make api call using axios
      axios
      .post("http://localhost:8080/User/signin", body)
      .then((response) => {
        window.sessionStorage.setItem("id",response.data.id);
        window.sessionStorage.setItem("role",response.data.role);
        window.sessionStorage.setItem("Name",response.data.fullName);
        // get the server result
        const result = response.data;
        console.log(result);

        window.sessionStorage.setItem("isUserLoggedIn" , true);
       

      
          toast.success("Welcome to the PGManagement");
          const message = 'Welcome to PGHouse'
          if (response.data.role == 'ADMIN') {
            console.log(response.data.role);
            
            const newLocation = { ...location, pathname: '/Admin' };
        const newLocationString = `${newLocation.pathname}${newLocation.search}${newLocation.hash}`;
        window.location.href = newLocationString;


            // navigate('/Admin', { state: { message } })
          } else if (response.data.role == 'USER') {
 
            const newLocation = { ...location, pathname: '/Home' };
            const newLocationString = `${newLocation.pathname}${newLocation.search}${newLocation.hash}`;
            window.location.href = newLocationString;
            // navigate('/Home', { state: { message } })
          } else 
          
          navigate('/Home', { state: { message } })
          
      });
    }
  };

  return (
    <div className="lead">
      <br/><br/><br/><br/><br/><br/>
      
      <div className="container col-4 mt-4 px-5 pb-5 shadow bg-body rounded">
        <div className="row justify-content-center">
          <div className="heading">User Signin</div>
          <div className="col">
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">
                Email address
              </label>
              <input
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                type="email"
                className="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
              />
              <div id="emailHelp" className="form-text">
                We'll never share your email with anyone else.
              </div>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">
                Password
              </label>
              <input
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                type="password"
                className="form-control"
                id="exampleInputPassword1"
              />
            </div>

            <button
              onClick={signinPerson}
              className=" w-100 btn btn btn-outline-dark"
            >
              Signin
            </button>
            <div className="form-label mt-2">
              Not yet registered?, <Link to="/signup">Register Here</Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Signin;
