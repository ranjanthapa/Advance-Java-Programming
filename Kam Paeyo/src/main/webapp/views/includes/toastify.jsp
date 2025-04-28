<div id="customToast" style="display:none; position:fixed; top:20px; right:20px; background:green; color:white; padding:10px 20px; border-radius:5px; box-shadow:0px 2px 10px rgba(0,0,0,0.3); z-index:9999;">
    ✅ Job posted successfully!
</div>

<script>
    function showCustomToast() {
        var toast = document.getElementById('customToast');
        toast.style.display = 'block';
        setTimeout(function() {
            toast.style.display = 'none';
        }, 3000);
    }
</script>

<%
    Boolean jobPosted = (Boolean) session.getAttribute("jobPosted");
    if (jobPosted != null && jobPosted) {
        session.removeAttribute("jobPosted");
%>
<script>
    showCustomToast();
</script>
<% } %>
