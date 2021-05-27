import 'antd/dist/antd.css';
import { Form, Button, Layout, Menu, message, Input, InputNumber, DatePicker } from 'antd';
import { Link } from 'react-router-dom';
import { useState } from 'react';

const { Header, Content, Footer } = Layout;

export default function CadastrarInvestimento() {

   const layout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 3 },
    };
    const tailLayout = {
      wrapperCol: { offset: 4},
    };

   const onFinish = (values) => {
      message.success("Investimento salvo com sucesso!")
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