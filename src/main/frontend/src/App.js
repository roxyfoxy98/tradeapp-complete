import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Landing from './components/Layout/Landing';
import Instruments from './components/Layout/Instruments';
import "bootstrap/dist/css/bootstrap.min.css";
import Login from './components/userManagement/Login';
import Register from './components/userManagement/Register';
import RegisterSuccess from './components/userManagement/RegisterSuccess';

class App extends Component {
    render() {
        return(
          <Router>
          <div className="app">
            <Route exact path="/" component={Landing} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/instruments" component={Instruments} />
            <Route exact path="/register-success" component={RegisterSuccess} />
          </div>
          </Router>
        )
    }
}

export default App;