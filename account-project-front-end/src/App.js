import React, { Component } from 'react';

import 'bootstrap/dist/css/bootstrap.css'
import Home from './Components/Home';
import SignUp from './Components/SignUp.js';
import {BrowserRouter as Router, Route} from 'react-router-dom'

export default class App extends Component {

  render() {
    return (
     <div>
      <Router>
        <div>
          <Route exact path="/" component={Home} />
          <Route path="/SignUp" component={SignUp} />
        </div>
      </Router>
      </div>
      
    );
  }
}
