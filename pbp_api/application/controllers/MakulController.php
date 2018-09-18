<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class MakulController extends CI_Controller {

    public function __construct(){
      parent::__construct();
      $models = array(
        'MakulModel' => 'MakulModel',
      );
      $this->load->model($models);
    }
    
    public function GetListMakul(){
    $response=array(
      'list_makul'=>$this->MakulModel->getListMakul()
    );

    $this->output
          ->set_status_header(200)
          ->set_content_type('application/json', 'utf-8')
          ->set_output(json_encode($response, JSON_PRETTY_PRINT))
          ->_display();
      exit;
  }

  public function InsertEvent()
  {
    $DataEvent = json_decode(file_get_contents('php://input'),true);
    $this->MakulModel->InsertEvent($DataEvent);
    $User=$this->MakulModel->getDataUser($DataEvent);

    $response=array(
        'success'=>true,
        'message'=>'registrasi berhasil',
        'data_user'=>$User
    );
    

    $this->output
    ->set_status_header(200)
    ->set_content_type('application/json', 'utf-8')
    ->set_output(json_encode($response, JSON_PRETTY_PRINT))
    ->_display();
    exit;
  }

  public function InserMakul()
  {
    $Makul = json_decode(file_get_contents('php://input'),true);
    $this->MenuModel->insertMenu($Makul);

    $response=array(
      'message'=>'Berhasil memasukkan menu'
    );

    $this->output
          ->set_status_header(200)
          ->set_content_type('application/json', 'utf-8')
          ->set_output(json_encode($response, JSON_PRETTY_PRINT))
          ->_display();
      exit;
  }
   
}

