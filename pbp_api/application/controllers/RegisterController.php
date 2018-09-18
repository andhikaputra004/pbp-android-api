<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class RegisterController extends CI_Controller {

    public function __construct()
    {
      parent::__construct();
      $models = array(
        'UserModel' => 'UserModel',
      );
      $this->load->model($models);
    }
    
    public function RegisterUser()
  {
    $DataUser = json_decode(file_get_contents('php://input'),true);
    if($this->UserModel->cekUsername($DataUser['username']))
    {
      $this->UserModel->insertUser($DataUser);
      $User=$this->UserModel->getDataUser($DataUser);

      $response=array(
        'success'=>true,
        'message'=>'registrasi berhasil',
        'data_user'=>$User
      );
    }
    else {
      $response=array(
        'success'=>false,
        'message'=>'id user sudah terdaftar'
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

