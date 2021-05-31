import axios from 'axios';

const API_URL = 'http://localhost:8080';

class CategoriaService {

   retrieveAllCategorias(){
      return axios.get(`${API_URL}/categorias`)
   }

   saveCategoria(categoria) {
      axios.post(`${API_URL}/categorias`, categoria)
   }

   deleteCategoria(codigo) {
      axios.delete(`${API_URL}/categorias/${codigo}`)
   }
}

export default new CategoriaService();