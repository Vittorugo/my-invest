import 'antd/dist/antd.css';
import { Form, Button, Layout, Menu, message, Input, InputNumber, DatePicker, Select } from 'antd';
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import InvestimentoService from '../../services/InvestimentoService';
import CategoriaService from '../../services/CategoriaService';

const { Header, Content, Footer } = Layout;
const { Option } = Select;

export default function CadastrarInvestimento() {

   const [categorias, setCategorias] = useState([]);
   const [categoria, setCategoria] = useState();

   useEffect( () => {
      refreshCategorias();
   },[]);

   async function refreshCategorias(){
      CategoriaService.retrieveAllCategorias().then(response => {
         setCategorias(response.data);
      })
   }

   function handleChange(value) {
      setCategoria(value);
   }

   const layout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 3 },
    };
    const tailLayout = {
      wrapperCol: { offset: 4},
    };

   const onFinish = (values) => {
      InvestimentoService.salveInvestimento(values);
      message.success("Investimento salvo com sucesso!");
   }

   const onFinishFailed = (errorInfo) => {
      message.danger("Falha ao salvar investimento!")
      console.log('Failed:', errorInfo);
   }

   return(
      <div className='container'>
         <Layout className="layout">
            <Header>
               <div className="logo" />
               <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
                  <Menu.Item key="1">
                     <Link to='/cadastrar-investimento'>
                        Cadastrar investimento
                     </Link>
                  </Menu.Item>
                  <Menu.Item key="2">
                     <Link to='/listar-investimentos'>
                        Listar investimentos
                     </Link>
                  </Menu.Item>
               </Menu>
            </Header>
            <Content style={{ padding: '0 50px' }}>
               <div className='site-layout-content'>
                  <h2>CADASTRAR INVESTIMENTOS</h2>
                  <Form {...layout} name='basic'
                  initialValues={{
                     remember: true,
                  }}
                  onFinish={onFinish}
                  onFinishFailed={onFinishFailed}>
                     <Form.Item label='Código Ativo'
                        name='codigoAtivo'
                        rules={[{
                           required:true,
                           message: 'Insira o código do ativo!',
                        },
                     ]}>
                        <Input />
                     </Form.Item>
                     <Form.Item label='Valor'
                        name='valorCota'
                        rules={[{
                           required:true,
                           message: 'Insira o valor da cota!',
                        },
                     ]}>
                        <InputNumber />
                     </Form.Item>
                     <Form.Item label='Quantidade de cotas'
                        name='quantidadeCotas'
                        rules={[{
                           required:true,
                           message: 'Insira a quantidade de cotas!',
                        },
                     ]}>
                        <InputNumber />
                     </Form.Item>
                     <Form.Item label='Data da compra'
                        name='dataCompra'
                        rules={[{
                           required:true,
                           message: 'Insira a data da compra!',
                        },
                     ]}>
                        <DatePicker />
                     </Form.Item>

                     <Form.Item label='Categoria'
                        name='categoria'
                        rules={[{
                           required:false,
                           message: 'Insira a categoria!',
                        },
                     ]}>
                        <Select  onChange={handleChange} >
                           {categorias.map( (item,index) => {
                              return(
                                 <Option key={item.id} value={item.id}>
                                    {item.nome}
                                 </Option>
                              )
                           })}
                        </Select>
                     </Form.Item>

                     <Form.Item {...tailLayout}>
                        <Button type='primary' htmlType='submit'>
                           Salvar
                        </Button>
                     </Form.Item>
                  </Form>
               </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>My Invest ©2021 </Footer>
         </Layout>,
      </div >
   );
}