<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class UserModel extends CI_Model{

    public function getDataUser($DataLogin){
    $this->db->select('*');
    $this->db->from('tbl_user');
    $this->db->where('username',$DataLogin['username']);
    $this->db->where('password',$DataLogin['password']);
    $DataUser=$this->db->get('')->row_array();
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return NULL;
    }
    else
    return $DataUser;
    }

    public function cekUsername($username){
    $this->db->select('*');
    $this->db->from('tbl_user');
    $this->db->where('username',$username);
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return true;
    }
    else {
      return false;
    }
  }

  public function insertUser($DataUser){
    $this->db->insert('tbl_user',$DataUser);
  }
}