<div id="modal-overlay" class="modal">
  <div class="modal-content">
    <h3>Confirm Deletion</h3>
    <p>Are you sure you want to delete this job?</p>
    <div class="modal-actions">
      <button id="confirmDelete" class="btn-delete">Delete</button>
      <button id="cancelDelete" onClick = "onCancel()" class="btn-cancel">Cancel</button>
    </div>
  </div>
</div>

<script>
    function onCancel(){
        document.getElementById("modal-overlay").style.display = "none";
    }
</script>
