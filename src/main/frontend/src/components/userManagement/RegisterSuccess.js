import React, {Component} from 'react';
import { Link } from "react-router-dom";
import PropTypes from 'prop-types';


class RegisterSuccess extends Component {
    // componentDidMount() {
    //     if(this.props.security.validToken) {
    //         this.props.history.push("/dashboard");
    //     }
    // }
    render() {
        return (
            <div className="landing">
                <div className="light-overlay landing-inner text-dark">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12 text-center">
                                <h1 className="display-3 mb-4">You have been successfully registered!</h1>
                                <p className="lead">
                                </p>
                                <hr />
                                <Link to="/login" className="btn btn-lg btn-secondary mr-2">
                                    Login
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        );
    }
}

// Landing.propTypes = {
//     security: PropTypes.object.isRequired
// }

// const mapStateToProps = state => ({
//     security: state.security
// });

export default RegisterSuccess;