<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class LoginMobileController extends CI_Controller {

    public function __construct()
    {
      parent::__construct();
      $models = array(
        'UserModel' => 'UserModel',
      );
      $this->load->model($models);
    }
    public function Login_mobile()
    {
      $DataLogin=json_decode(file_get_contents('php://input'),true);
      $data=$this->UserModel->getDataUser($DataLogin);
      if($data!=NULL)
      {
        $response=array(
          'success'=>true,
          'message'=>'berhasil masuk',
          'datapelanggan'=>$data
        );
      }
      else {
        $response=array(
          'success'=>false,
          'message'=>'id pengguna/katasandi salah'
        );
      }
  
      $this->output
      ->set_status_header(200)
      ->set_content_type('application/json', 'utf-8')
      ->set_output(json_encode($response, JSON_PRETTY_PRINT))
      ->_display();
      exit;
    }
}

