import axios from 'axios';

const axiosPublicInstance = axios.create({
  baseURL: 'https://railwayhostingtest-production.up.railway.app', // backend base URL
});

export default axiosPublicInstance;