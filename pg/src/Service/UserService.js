import axios from 'axios';

const BASE_URL = 'http://localhost:8080/User';

class UserService {
  signin(reqs) {
    return axios.post(`${BASE_URL}/signin`, reqs)
      .then(response => response.data)
      .catch(error => Promise.reject(error.response.data));
  }

  signup(userDto) {
    return axios.post(`${BASE_URL}/Signup`, userDto)
      .then(response => response.data)
      .catch(error => Promise.reject(error.response.data));
  }


}

export default new UserService();
