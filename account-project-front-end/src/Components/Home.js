import React, { Component } from 'react';

import 'bootstrap/dist/css/bootstrap.css'
import NavBar from './NavBar'


export default class Home extends Component {

    render() {
        return (
            <div>
                <NavBar />
                <img src="https://images.pexels.com/photos/2098405/pexels-photo-2098405.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=2000" alt="This is my home screen ... get it? ;-) "></img>
                
            </div>

        );
    }
}
