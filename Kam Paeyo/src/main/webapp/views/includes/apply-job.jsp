<div class="modal-overlay" id="jobApplyOverlay">
    <div class="apply-job-form">
       <div class="form-header">
           <h2>Apply Job</h2>
           <button class="x-btn" onclick="closeApplyForm()"><i class="fa-solid fa-x"></i></button>

       </div>
        <hr class="divider">

      <form enctype="multipart/form-data">

        <div class="input-container">
          <input type="text" name="name" placeholder=" " required />
          <label for="name">Name</label>
        </div>

        <div class="input-container">
          <input type="email" name="email" placeholder=" " required />
          <label for="email">Email</label>
        </div>

        <div class="input-container">
          <input type="tel" name="contact" placeholder=" " required />
          <label for="contact">Contact Number</label>
        </div>

        <div class="input-container text-area-container">
          <textarea name="cover-letter" placeholder=" " rows="3" required></textarea>
          <label for="cover-letter">CoverLetter</label>
        </div>

        <div class="input-container file-input">
          <input type="file" name="resume" required />
        </div>

       <hr class="divider"/>
        <div class="button-group">
          <button type="button" class="btn cancel-btn" onclick="closeApplyForm()">Close</button>
          <button type="submit" class="btn apply-btn">Apply Now</button>
        </div>
      </form>
    </div>
</div>


<script src="scripts/index.js"></script>