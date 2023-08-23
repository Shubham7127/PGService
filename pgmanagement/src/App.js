import './App.css';
import { BrowserRouter as Router, Route, Switch, Routes } from 'react-router-dom';
import PropertyForm from './screens/Adminscreen';

function App() {
  return (
    <Router>
    <div className="App">
      <Switch>
        <Route exact path="/" component={PropertyForm} />
      </Switch>
     
    </div>
  </Router>
  );
}

export default App;
