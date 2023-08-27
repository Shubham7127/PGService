import { BrowserRouter, Route ,Routes,Router} from 'react-router-dom';
import React from 'react';
import './App.css';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';
import Signin from './pages/Signin/Signin';
import Home from './pages/Home/Home';
import Delhi from './components/Delhi';
import Register from './pages/Register/Register';
import Pglist from './components/Pglist';
import Allpglist from './components/Allpglist';
import PropertyDetail from './components/PropertyDetail';
import Register1 from './pages/sgn';
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import ContactUs from './pages/Contact/Contactus';
import Admin from './components/ Admin';
import FacilitiesChange from './components/FacilitiesChange';
import CitiesChange from './components/CitiesChange';
import ProtectedRoute from './ProtectedRoute';
import CitiesList from './components/CitiesList';
import CitiesPage from './components/CitiesPage';
import FacilitiesPage from './components/FacilitiesPage';
function App() {
  return (
    <div>
      <BrowserRouter>
       <Navbar/>
        <Routes>
          
          <Route path="/" element={<Home/>} /> 
          <Route path="/Home" element={<Home/>} /> 
          <Route path='/:cityName' element={<Delhi/>} />
          <Route path='/signin' element={<Signin/>} />
          <Route path='/signup' element={<Register/>} />
          {/* <Route path='/PropertyDetail' element={<PropertyDetail/>} /> */}
          <Route path='/Contactus' element={<ContactUs/>} />
          <Route path='/Admin' element={<Admin/>} />
          <Route path='/properties' element={<PropertyDetail/>} />
          <Route path='/facilities' element={<FacilitiesChange/>} />
          <Route path='/cities' element={<CitiesChange/>} />
           <Route path='/CitiesList' element={<CitiesList/>} />
           <Route path='/CitiesPage' element={<CitiesPage/>} />
           <Route path='/FacilitiesPage' element={<FacilitiesPage/>} />
          
          <Route path="/PropertyDetail" 
          render={(props)=>(
           <ProtectedRoute {...props} exact path="/PropertyDetail" component={PropertyDetail}  />

          )}
          />



        </Routes>
        {/* <ProtectedRoute path="/PropertyDetail" element={PropertyDetail}  ></ProtectedRoute> */}

       <Footer/>
    </BrowserRouter>
    <ToastContainer theme="colored" />
    </div>
  );
}

export default App;
