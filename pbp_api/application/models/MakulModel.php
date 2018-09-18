<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class MakulModel extends CI_Model{

    public function getListMakul(){
    $DataMakul=[];
    $this->db->select('k.id_makul,k.nama_makul,k.nama_dosen,k.lokasi_makul,u.nama_event');
    $this->db->from('tbl_makul k');
    $this->db->join('tbl_event u','k.id_event=u.id_event');
    $DataMakul=$this->db->get('')->result_array();
    return $DataMakul;
    }


  public function insertEvent($DataEvent)
  {
    $this->db->insert('tbl_event',$DataEvent);
  }
  public function InsertMakul($Makul){
    $this->db->insert('tbl_makul',$Makul);
  }
}