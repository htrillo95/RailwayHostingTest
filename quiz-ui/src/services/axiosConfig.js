import axios from 'axios';

const axiosAuthInstance = axios.create({
  withCredentials: true,
  baseURL: 'https://railwayhostingtest-production.up.railway.app', // backend base URL
});

export default axiosAuthInstance;