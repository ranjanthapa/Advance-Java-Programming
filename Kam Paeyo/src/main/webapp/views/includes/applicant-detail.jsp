<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>

<div class="modal-overlay" id="jobApplyOverlay" style="display: none;">
    <div class="apply-job-form">
        <div class="form-header">
            <h2>Applicant Details</h2>
            <button class="x-btn" onclick="closeApplyForm()">
                <i class="fa-solid fa-x"></i>
            </button>
        </div>
        <hr class="divider">

       <form action="${pageContext.request.contextPath}/admin/application" method="post">

            <div class="input-container">
                <input type="text" id="applicant-name" name="name" placeholder=" " disabled />
                <label for="applicant-name">Name</label>
            </div>

            <input type="text" id="app-id" name="app_id" placeholder=" "  hidden/>

            <div class="input-container">
                <input type="email" id="applicant-email" name="email" placeholder=" "  disabled/>
                <label for="applicant-email">Email</label>
            </div>

            <div class="input-container">
                <input type="tel" id="applicant-contact" name="contact" placeholder=" "  disabled  />
                <label for="applicant-contact">Contact Number</label>
            </div>

            <div class="input-container text-area-container">
                <textarea id="applicant-cover-letter" name="cover-letter" placeholder=" " rows="3" disabled></textarea>
                <label for="applicant-cover-letter">Cover Letter</label>
            </div>

            <div class="input-container">
                <a id="resumeLink" href="#" target="_blank" class="btn btn-sm" style="margin-top: 5px;">View Resume</a>
            </div>

            <div class="input-container">
                <select name="status" id="appStatus" required>
                    <option value="pending">Pending</option>
                    <option value="accepted">Accepted</option>
                    <option value="rejected">Rejected</option>
                </select>
            </div>

            <hr class="divider" />
            <div class="button-group">
                <button type="button" class="btn cancel-btn" onclick="closeApplyForm()">Cancel</button>
                <button type="submit" class="btn apply-btn">Update Now</button>
            </div>
        </form>
    </div>
</div>
