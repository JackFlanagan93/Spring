import React, { Component } from 'react';
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import { faUserPlus } from "@fortawesome/free-solid-svg-icons"
import { faSignInAlt } from "@fortawesome/free-solid-svg-icons"
import { faUsers } from "@fortawesome/free-solid-svg-icons"
import { faHome } from "@fortawesome/free-solid-svg-icons"


import 'bootstrap/dist/css/bootstrap.css'
import {Collapse, Navbar, NavbarToggler, NavbarBrand, Nav,
    NavLink, UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
    
    library.add(faUserPlus, faSignInAlt, faUsers, faHome);
class NavBar extends Component {
    constructor(props) {
        super(props);
    
        this.state = {
          isOpen: false
        };
      }
      
      toggle = () => {
        this.setState({
          isOpen: !this.state.isOpen
        });
      }
 
    render(){
        return(
<div>
        <Navbar color="dark" light expand="md">
        <NavbarBrand href="/" >Home</NavbarBrand>
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              
              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle nav caret>
                  Menu
                </DropdownToggle>
                <DropdownMenu right>
                <DropdownItem>
                  <NavLink href="/">
                  <FontAwesomeIcon icon={["fas", "home"]} /> | Home
                  </NavLink>
                  </DropdownItem>

                  <DropdownItem>
                  <NavLink href="/SignUp">
                  <FontAwesomeIcon icon={["fas", "user-plus"]} /> | Sign Up
                  </NavLink>
                  </DropdownItem>
                
                  <DropdownItem>
                  <NavLink href="/Login">
                  <FontAwesomeIcon icon={["fas", "sign-in-alt"]} /> | Login
                  </NavLink>
                  </DropdownItem>

                  <DropdownItem divider />
                                 
                </DropdownMenu>
              </UncontrolledDropdown>
            </Nav>
          </Collapse>
        </Navbar>
        
      </div>
        );
    }
};
export default NavBar